pipeline {
  agent any
  try {

  }
  catch(all) {

  }
  stages {
    stage('Checkout SCM') {
      steps {
        git(url: 'https://github.com/khldabdul/automation-test-blibli.git', branch: 'master')
      }
    }
    stage('API Test') {
      steps {
          script {
            try {
                bat 'mvn verify -Dcucumber.options="--tags @API"'
            } catch (e) {
                print e
            }
          }
      }
    }
    stage('UI Test') {
      parallel {
        stage('Chrome') {
          steps {
            bat 'mvn verify -Dcucumber.options="--tags @UI" -Dwebdriver.driver=chrome'
          }
        }
        stage('Firefox') {
          steps {
            bat 'mvn verify -Dcucumber.options="--tags @UI" -Dwebdriver.driver=firefox'
          }
        }
      }
    }
    stage('Results') {
      steps {
        publishHTML (target: [
          allowMissing: false,
          alwaysLinkToLastBuild: false,
          keepAll: true,
          reportDir: 'target/site/serenity',
          reportFiles: 'index.html',
          reportName: "Serenity Report"
        ])
      }
    }
  }
}