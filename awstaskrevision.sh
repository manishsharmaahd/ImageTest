rm -f  /tmp/ataskjsonresult
rm -f /tmp/taskdef.json
export PATH=/var/lib/jenkins/.local/bin:$PATH
cp /var/lib/jenkins/taskdef.json /tmp/taskdef.json
echo $1
sed -i -e "s/vesrionofbuild/$1/g" /tmp/taskdef.json
/root/.local/bin/aws ecs register-task-definition --cli-input-json file:///tmp/taskdef.json > /tmp/ataskjsonresult
cat /tmp/ataskjsonresult
VERSION=`cat /tmp/ataskjsonresult | grep revision | cut -f 2 -d ":" | sed -e 's/^[[:space:]]*//'`
rm -f  /tmp/ataskjsonresult
rm -f /tmp/taskdef.json
echo $VERSION > /tmp/latesttaskdefversion
cat /tmp/latesttaskdefversion