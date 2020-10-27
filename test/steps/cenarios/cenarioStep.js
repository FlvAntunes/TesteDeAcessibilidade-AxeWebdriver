var { Given, When, Then, } = require("cucumber");
var { setDefaultTimeout } = require("cucumber");
// var axe = require('axe-core');

const axe = require('axe-webdriverjs');

setDefaultTimeout(80 * 1000);

var chai = require('chai');
var chaiAsPromised = require('chai-as-promised');
chai.use(chaiAsPromised);
var expect = chai.expect;

var page = require('../../Page/loginPage');
var transfPage = require('../../Page/transferPage');
var utils = require('../../scripts/utils');
var acessibility = require('../../scripts/accessibility');

var driver = browser.driver;
// var driver = new Webdriver.Builder().forBrowser('chrome').build();


Given('que o usuario acesse o site {string}', function (url) {

    return driver.get(url);
});


Given('realize o login com o usuario {string} e senha {string}', function (username, password) {
    utils.elementClick(page.BotaoLogin);
    utils.fillText(page.CampoUsuario, username);
    utils.fillText(page.CampoSenha, password);
    return utils.elementClick(page.BotaoSingin);
});


When('ele acessar a funcionalidade de transferencia', function () {
    return utils.elementClick(transfPage.AbaTransferencia);
});

When('preencher o valor {string}', function (string) {
    return utils.fillText(transfPage.CampoValor, string);
});

When('confirmar a transferencia', function () {
    utils.elementClick(transfPage.BotaoContinue)
    return utils.elementClick(transfPage.BotaoContinue)
});

Then('deve ser exibido a mensagem {string}', function (string) {
    return expect(element(transfPage.MensagemTransfSucesso).getText()).to.eventually.equal(string)
});


Then('verifico o padrão de melhores praticas de acessibilidade', function () {
    return acessibility.checkBestPractice();
});

Then('verifico o padrão de acessibilidade wcag21aa', function () {
    return acessibility.checkWcag21aa();
});

Then('verifico se padrão de acessibilidade possui todas as diretrizes', function () {
    return acessibility.checkAll();
});

