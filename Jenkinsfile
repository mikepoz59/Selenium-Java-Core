pipeline {
    agent {
        any {
            image 'maven:3.9.5-eclipse-temurin-11-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
		stage('Test') {
            steps {
                sh 'mvn clean test' 
            }
			post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
    }
}
