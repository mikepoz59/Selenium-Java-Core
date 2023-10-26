pipeline {
    agent any
    tools { 
       maven 'Maven 3.9.5' 
       jdk 'jdk11'
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
