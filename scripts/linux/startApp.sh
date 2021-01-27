#!/bin/bash

# Ensure correct docker env is loaded
eval $(minikube -p minikube docker-env)

# Build the image
docker build -t echokube .

# Create resources
kubectl apply -f conf/k8s/app.yaml

# Expose service
minikube service echokube-service

# reset docker env
eval $(minikube docker-env -u)
