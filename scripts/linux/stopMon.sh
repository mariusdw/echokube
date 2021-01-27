#!/bin/bash

# get rid of running resources.
kubectl delete deployment prometheus-deployment
kubectl delete deployment grafana-deployment

# get rid of port reservation.
kubectl delete service prometheus-service
kubectl delete service grafana-service
