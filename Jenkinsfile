pipeline {
    agent any

    tools {
        maven "M3"
        jdk "JDK"
    }

    stages {
        stage('Initialize'){
            steps{
                echo "PATH = ${M2_HOME}/bin:${PATH}"
                echo "M2_HOME = /opt/maven"
                echo "JAVA_HOME = /opt/java/openjdk"
            }
        }
        stage('Build') {
            steps {
                dir("/var/jenkins_home/workspace/New_demo/my-app/") {
                sh 'mvn -B -DskipTests clean package'
                }

            }
        }
     }
    post {
       always {
          junit(
        allowEmptyResults: true,
        testResults: '*/test-reports/.xml'
      )
      }
   }
}