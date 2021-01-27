#!/bin/bash

# Ensure correct docker env is loaded
eval $(minikube -p minikube docker-env)

# Build the image
docker build -t ek/prometheus -f Prometheus.Dockerfile .
docker build -t ek/grafana -f Grafana.Dockerfile .

# Create resources
kubectl apply -f conf/k8s/monitoring.yaml

# Expose service
minikube service prometheus-service
minikube service grafana-service

# reset docker env
eval $(minikube docker-env -u)
