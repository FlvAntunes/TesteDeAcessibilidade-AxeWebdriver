"use strict";

const axe = require('axe-webdriverjs');
var chai = require('chai');
var chaiAsPromised = require('chai-as-promised');
chai.use(chaiAsPromised);
var expect = chai.expect;



//https://medium.com/capital-one-tech/accessibility-regression-with-protractor-in-less-than-30-minutes-9abf1fd4f558

exports.checkBestPractice = async function () {
    /**
    * Available tags: wcag2a, wcag2aa, wcag21a, wcag21aa,
    * section508, best-practice, experimental, cat.
    */
    let results = await axe(browser.driver)
        .withTags(['wcag21aa', 'cat.*', 'best-practice']).analyze();
    // console.log(results);
    /**
    * Check the results for violations. If there are any, indicate
    * what they are.
    */
    return expect(results.violations.length).to.be.equal(
        0,
        `Accessibility Violations Found: ${JSON.stringify(results.violations, null, 2)}`
    );
}

exports.checkWcag21aa = async function () {
    /**
    * Available tags: wcag2a, wcag2aa, wcag21a, wcag21aa,
    * section508, best-practice, experimental, cat.
    */
    let results = await axe(browser.driver)
        .withTags(['cat.*','wcag21aa',]).analyze();
    /**
    * Check the results for violations. If there are any, indicate
    * what they are.
    */
    return expect(results.violations.length).to.be.equal(
        0,
        `Accessibility Violations Found: ${JSON.stringify(results.violations, null, 2)}`
    );
}

exports.checkAll = async function () {
    /**
    * Available tags: wcag2a, wcag2aa, wcag21a, wcag21aa,
    * section508, best-practice, experimental, cat.
    */
    let results = await axe(browser.driver).analyze();
    /**
    * Check the results for violations. If there are any, indicate
    * what they are.
    */
    return expect(results.violations.length).to.be.equal(
        0,
        `Accessibility Violations Found: ${JSON.stringify(results.violations, null, 2)}`
    );
}