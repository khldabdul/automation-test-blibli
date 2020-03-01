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
         try {
              bat 'mvn verify -Dcucumber.options="--tags @API"'
          }
          catch (exc) {
          }
      }
    }
    stage('UI Test') {
      parallel {
        stage('Chrome') {
          steps {
            try {
                bat 'mvn verify -Dcucumber.options="--tags @UI" -Dwebdriver.driver=chrome'
            }
            catch (exc) {
            }
          }
        }
        stage('Firefox') {
          steps {
            try {
                bat 'mvn verify -Dcucumber.options="--tags @UI" -Dwebdriver.driver=firefox'
            }
            catch (exc) {
            }
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