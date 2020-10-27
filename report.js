const report = require('multiple-cucumber-html-reporter');

report.generate({
    jsonDir: 'results',
    reportPath: '.tmp/Relatorio_completo',
    openReportInBrowser: true,
    removeExistingJsonReportFile: true,
    removeOriginalJsonReportFile: true,
    saveCollectedJSON: true,
    pageTitle: 'Test Report',
    reportName: '<b>Test Report</b>',
    pageFooter: '<div align="center"><p><a href="http://www.google.com.br">www.LinkDeteste.com.br</a></p></div>',
    displayDuration: true,
    durationInMS: true,
    customMetadata: false,
    metadata: {
        browser: {
            name: 'chrome',
            version: '84'
        },
        platform: {
            name: 'windows',
            version: '10'
        }
    },

    customData: {
        title: 'Run info',
        data: [
            { label: 'Project', value: "Projeto Teste" },
        ]
    },

});