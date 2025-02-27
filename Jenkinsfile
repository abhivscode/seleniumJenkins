pipeline {
    agent any
    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/abhivscode/seleniumJenkins.git'
            }
        }
        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test'  // Runs Selenium tests using Maven
            }
        }
    }
}
