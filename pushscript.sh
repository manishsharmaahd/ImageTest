export PATH=/root/.local/bin:$PATH
eval $(aws ecr get-login | sed 's|https://||')
docker tag finefeather:latest 272461118117.dkr.ecr.ap-south1.amazonaws.com/finefeather:$1
docker push 272461118117.dkr.ecr.ap-south-1.amazonaws.com/finefeather:$1
