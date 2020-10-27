exports.config = {
    // set to "custom" instead of cucumber.
    framework: 'custom',
    directConnect: true,
    restartBrowserBetweenTests: false,

    // path relative to the current config file
    frameworkPath: require.resolve('protractor-cucumber-framework'),

    capabilities: {
        shardTestFiles: false,
        maxInstances: 1,
        browserName: 'chrome',
        "seleniumProtocol": "WebDriver",

        metadata: {
            device: 'Local test machine',
            platform: {
                name: 'Windows',
                version: '10'
            }
        }
    },

    // require feature files
    specs: [
        'test/features/**/*.feature'
    ],

    cucumberOpts: {

        ignoreUncaughtExceptions: true,
        strict: true,
        format: 'json:results/results.json',
        'dry-run': false,
        plugin: 'pretty',
        // require step definitions
        require: [
            'test/steps/**/*.js'
        ]
    }
};
