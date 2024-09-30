pipeline {
    agent any

      tools {
        // Use the exact JDK name as configured in Global Tool Configuration
        jdk 'jdk-17.0.12'
        // Use the exact Maven name as configured in Global Tool Configuration
        maven 'maven-3.6.3'
    }
    
    stages {
        stage('Clone Repository') {
            steps {
                // Clone the code from Git
                git branch: 'main', url: 'https://github.com/Siddharth-Bhadra/Jenkins.git'
            }
        }
        stage('Build') {
            steps {
                // Command to build your website (replace as necessary)
                sh 'mvn clean install' // For Java
            }
        }
        stage('Test') {
            steps {
                // Run tests (if any)
                sh 'mvn test' // 
            }
        }
        stage('Run Application') {
            steps {
                // Run the Java application
                sh 'java -jar target/app.jar' // Adjust the path to your JAR file
            }
        }
        stage('Deploy') {
            steps {
               // Optional: Deploy the application (if needed)
                // Example for SCP deployment to a server
                sh 'scp -r target/app.jar user@targetVM:/path/to/deployment'
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
