pipeline {
    agent any
    stages {
        stage('Build Backend') {
            steps {
                bat './mvnw.cmd clean package'
            }
        }
        stage('Run Backend Tests') {
            steps {
                bat './mvnw.cmd test'
            }
        }
        stage('Build Frontend') {
            steps {
                bat 'npm install'
                bat 'ng build --prod'
            }
        }
        stage('Run E2E Tests') {
            steps {
                bat 'npm run e2e'
            }
        }
    }
}
