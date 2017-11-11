export PATH=/root/.local/bin:$PATH
eval $(aws ecr get-login | sed 's|https://||')
docker tag ffdc:$1 019066669311.dkr.ecr.ap-southeast-1.amazonaws.com/ffdc:$1
docker push 019066669311.dkr.ecr.ap-southeast-1.amazonaws.com/ffdc:$1