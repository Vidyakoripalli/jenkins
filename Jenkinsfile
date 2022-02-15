pipeline {
    agent any
    triggers {
        cron('@hourly')
        pollSCM('* * * * *')
    }
    options {
        buildDiscarder(logRotator(daysToKeepStr: '30'))
        disableConcurrentBuilds()
    }
    tools {
        maven 'Maven 3'
        jdk 'open-jdk8'
    }
    stages {
        stage ('Checkout') {
            steps {
                git url: 'https://github.com/tsundberg/maven-build-with-jenkins-pipeline.git', branch: "master"
            }
        }
        stage('Run integration tests') {
            steps {
                sh "mvn clean test"
            }
        }
    }
    post {
        always {
            archiveArtifacts "target/**/*"
            junit "target/**/surefire-reports/*.xml,target/**/failsafe-reports/*.xml"
        }
    }
}