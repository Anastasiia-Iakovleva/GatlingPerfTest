pipeline {
    agent any
    stages {
        stage("Build Maven") {
            steps {
                sh 'mvn clean scala:testCompile'
            }
        }
        stage("Run Gatling") {
            steps {
                sh 'mvn gatling:test'
            }
            post {
                always {
                    gatlingArchive()
                }
            }
        }
    }
}