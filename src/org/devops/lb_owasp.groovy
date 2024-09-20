package org.devops

def analisisOWASP(){
    sh "docker run --rm -v fullscan_react-test_OWASP:/zap/wrk/:rw --user root -t owasp/zap2docker-stable zap-full-scan.py -t http://${env.dominio}:5174/ -r fullscan_react-test_OWASP.html -I"
}
