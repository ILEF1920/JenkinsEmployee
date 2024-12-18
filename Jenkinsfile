pipeline {
    agent any
    stages {
        stage('Build Backend') {
            steps {
                sh './mvnw clean package'
            }
        }
        stage('Run Backend Tests') {
            steps {
                sh './mvnw test'
            }
        }
        stage('Build Frontend') {
            steps {
                sh 'npm install'
                sh 'ng build --prod'
            }
        }
        stage('Run E2E Tests') {
            steps {
                sh 'npm run e2e'
            }
        }
    }
}
