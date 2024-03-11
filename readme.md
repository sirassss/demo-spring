docker build -t alsenpaiii/demo-spring-layer --no-cache -f demo.app_layer.Dockerfile .
docker container run --name demo_container -d -p 8082:8082 alsenpaiii/demo-spring-layer