#!/bin/bash

# get rid of running resources.
kubectl delete deployment echokube-deployment

# get rid of port reservation.
kubectl delete service echokube-service
