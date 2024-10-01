pipeline {
    agent any

     tools {
        // Use the correct JDK version configured in Jenkins
        jdk 'jdk-17.0.12'  // Adjust to match your configuration
    }

    environment{
        SONARQUBE_SCANNER_HOME = tool 'SonarQubeScanner'
    }
    
    stages {
        stage('Clone Repository') {
            steps {
                // Clone the code from Git
                git branch: 'main', url: 'https://github.com/Siddharth-Bhadra/Jenkins.git'
            }
        }

         stage('Compile') {
            steps {
                // Compile the Java file
                sh 'javac App.java'
            }
        }
        stage('SAST with SonarQube') {
            steps {
                withSonarQubeEnv('SonarQubeServer') {  // Replace with your SonarQube server name
                    sh '''
                        ${SONARQUBE_SCANNER_HOME}/bin/sonar-scanner \
                        -Dsonar.projectKey=your-project-key \
                        -Dsonar.sources=. \
                        -Dsonar.host.url=http://localhost:9000
                    '''
                    }
                }
            }
        }

          stage('Run Application') {
            steps {
                // Run the compiled Java class
                sh 'java -cp . App'
            }
        }

        
        stage('Test') {
            steps {
                // If you have tests, you can add test steps here
                echo 'No tests to run for now'
            }
        }
    }
     post {
        always {
            // Clean up or send notifications, if required
            echo 'Pipeline completed'
        }
        success {
            echo 'Pipeline completed successfully'
        }
        failure {
            echo 'Pipeline failed'
        }
    }
}
