pipeline {
    agent any
    stages {
        stage("Build Maven") {
            steps {
                bat 'mvn clean scala:testCompile'
            }
        }
        stage("Run Gatling") {
            steps {
                bat 'mvn gatling:test'
            }
            post {
                always {
                    gatlingArchive()
                }
            }
        }
    }
}