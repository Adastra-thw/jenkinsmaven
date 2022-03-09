pipeline {
    agent any
      
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('sast') {
            steps {
                sh 'sonar-scanner -Dsonar.projectKey=GOAT2 -Dsonar.sources=. -Dsonar.java.libraries=. -Dsonar.java.binaries=. -Dsonar.host.url=http://localhost:9000 -Dsonar.login=daaee8ed57f0be6e34c77247a5809d022c421a68'
            }
        }
    }
}
