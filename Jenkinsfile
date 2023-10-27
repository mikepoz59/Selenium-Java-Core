pipeline {
    agent any
    tools { 
	    // the values must be what's configured in the Jenkins -> Manage Jenkins -> Tools section 
        maven 'MAVEN 3.9.5' // Name of the Maven installations entry
        jdk 'Java JDK'      // Name of the JDK installation entry
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
