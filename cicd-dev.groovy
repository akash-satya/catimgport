node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/catimgport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/catimgport.git'), string(name: 'PORT_DESCRIPTION', value: 'Catimg is a tool which is used to print images to the terminal' ), string(name: 'BUILD_LINE', value: 'DEV') ]
  }
}
