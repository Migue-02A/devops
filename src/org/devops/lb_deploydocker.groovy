package org.devops

def despliegueContenedor(projectName){
    sh "docker rm ${projectName}"
    sh "docker pull miguelgomez02/react-test"
    sh "docker run -d --name ${projectName} --network=${env.NET_NAME} -p 5174:5174 --user root miguelgomez02/${projectName}"
}
