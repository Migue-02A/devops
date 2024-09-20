package org.devops

def despliegueContenedor(projectGitName){
    sh "docker pull miguelgomez02/react-test"
    sh "docker run -d --name ${projectGitName} --network=${env.NET_NAME} -p 5174:5174 --user root miguelgomez02/${projectGitName}"
}
