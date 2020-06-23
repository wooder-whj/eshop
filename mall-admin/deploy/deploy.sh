#!/bin/bash
mvn clean package
kubectl delete -f ./deploy/deploy.yaml --ignore-not-found=true
kubectl apply -f ./deploy/deploy.yaml
host=`grep docker.host pom.xml|awk --re-interval '{match($0,/([0-9]{1,3}\.){3}[0-9]{1,3}/,a); print a[0]}'`
echo host=$host
ids=`ssh root@$host "docker images|grep \"<none>\""|awk '{print $3}'`
for id in $ids; do
  echo id=$id
  ssh root@$host "docker rmi -f $id"
done
version=`awk '/<version>[^<]+<\/version>/{gsub(/<version>|<\/version>/,"",$1);print $1;exit;}' pom.xml`
echo version=$version
artifact=`awk '/<artifactId>[^<]+<\/artifactId>/{gsub(/<artifactId>|<\/artifactId>/,"",$1);print $1;exit;}' pom.xml`
echo artifact=$artifact
master=`kubectl get nodes -o wide|grep master|awk '{print $6}'`
for node in `kubectl get nodes -o wide|awk -F ' ' 'NR>1 { print $6 }'`; do
    if [ $host != $node ] && [ $node != $master  ]; then
       echo node=$node
       docker save -o /tmp/$JOB_NAME.tar mall/$artifact:$version
       scp /tmp/$JOB_NAME.tar root@$node:/tmp/$JOB_NAME.tar
       ssh root@$node "docker load -i /tmp/$JOB_NAME.tar"
    fi
done