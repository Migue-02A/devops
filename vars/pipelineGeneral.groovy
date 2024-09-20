def call(Map param){

    pipeline{

        agent any

        tools{
            nodejs 'NodeJS'
        }

        /* triggers {
             pollSCM('* * * * *') // Programa la verificación del repositorio cada minuto
        } */

        environment{
            PROJECT = "${env.GIT_URL}".replaceAll('.+/(.+)\\.git', '$1').toLowerCase()
        }

        stage('Construccion App') {
            steps {
                script {
                    def buildapp = new org.devops.lb_buildartefacto()
                    buildapp.install()
                    def cloneapp = new org.devops.lb_buildartefacto()
                    cloneapp.clone()
                }
            }
        }

        stage('Analisis Sonarqube') {
            steps {
                script {
                    def test = new org.devops.lb_analisissonarqube()
                    test.testCoverage()
                    def analisisSonar = new org.devops.lb_analisissonarqube()
                    analisisSonar.analisisSonar("$PROJECT")
                }
            }
        }
        
    }
}
