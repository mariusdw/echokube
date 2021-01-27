#EchoKube example project.

EchoKube demonstrates a simple REST service deployed in Kubernetes. 

Running through minikube:

1) Compile application jar file to latest version.
```
mvnw package
```
2) Ensure minikube, docker and kubectl are installed.
   Start up minikube cluster
```
minikube start --vm-driver=docker
```
3) Run the following
```
scripts/startApp.sh
```
This creates the app resources.

4) Once done, run: 
```
scripts/stopApp.sh
```
This cleans up app resources.
5) Minikube can now be stopped:
```
minkube stop
```
Close and open a new terminal to reset your docker env.