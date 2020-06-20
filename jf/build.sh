# 移动当前文件上级目录再执行dockerfile 生成容器
mv Dockerfile ../
cd ../
docker build -f ./Dockerfile -t jf:v1.0 .
