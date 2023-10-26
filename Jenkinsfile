pipeline {
    agent any
    tools { 
       maven 'MAVEN 3.9.5' 
       jdk 'Java JDK'
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
