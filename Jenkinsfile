pipeline {
    agent any
    
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
                sh 'mvn clean --file *.pom' // For Java
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
                sh 'java -jar target/App.jar' // Adjust the path to your JAR file
            }
        }
        stage('Deploy') {
            steps {
               // Optional: Deploy the application (if needed)
                // Example for SCP deployment to a server
                echo 'done!!!!'
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
