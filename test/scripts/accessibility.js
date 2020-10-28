"use strict";

const axe = require('@axe-core/webdriverjs');
var chai = require('chai');
var chaiAsPromised = require('chai-as-promised');
chai.use(chaiAsPromised);
var expect = chai.expect;

var builder = new axe(browser.driver);



exports.checkBestPractice = async function () {
    /**
    * Available tags: wcag2a, wcag2aa, wcag21a, wcag21aa,
    * section508, best-practice, experimental, cat.
    */
    let results = await builder.withTags(['wcag21aa', 'cat.*', 'best-practice']).analyze();
    /**
    * Check the results for violations. If there are any, indicate
    * what they are.
    */
    return expect(results.violations.length).to.be.equal(
        0,
        `Accessibility Violations Found: ${JSON.stringify(results.violations, null, 2)}`
    );
};


exports.checkWcag21aa = async function () {
    /**
    * Available tags: wcag2a, wcag2aa, wcag21a, wcag21aa,
    * section508, best-practice, experimental, cat.
    */
    let results = await builder.withTags(['cat.*', 'wcag21aa',]).analyze();

    return expect(results.violations.length).to.be.equal(
        0,
        `Accessibility Violations Found: ${JSON.stringify(results.violations, null, 2)}`
    );
}

exports.checkAll = async function () {
    let results = await builder.analyze();

    return expect(results.violations.length).to.be.equal(
        0,
        `Accessibility Violations Found: ${JSON.stringify(results.violations, null, 2)}`
    );
}