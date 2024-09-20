package org.devops

def despliegueContenedor(projectName) {
    sh "docker stop ${projectName} || true"
    sh "docker rm ${projectName} || true"
    
    def networkName = env.NET_NAME ?: 'default_network' // Valor por defecto
    println "Network name: ${networkName}"
    
    sh "docker pull miguelgomez02/${projectName}"
    sh "docker run -d --name ${projectName} --network=${networkName} -p 5174:5174 --user root miguelgomez02/${projectName}"
}
