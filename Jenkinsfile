pipeline {
    agent any

     tools {
        // Use the correct JDK version configured in Jenkins
        jdk 'jdk-17.0.12'  // Adjust to match your configuration
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
