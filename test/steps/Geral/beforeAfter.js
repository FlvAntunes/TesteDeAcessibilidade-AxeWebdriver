"use strict";
var { After, Before} = require("cucumber");


var driver = browser.driver;



function clearStorage() {
  window.sessionStorage.clear();
  window.localStorage.clear();
}




/********* LOGIN ************/
Before(function () {
  return browser.waitForAngularEnabled(false);
  // browser.driver.manage().window().maximize();
  // browser.manage().window().setSize(1600,2400); 
  // return driver.get("http://zero.webappsecurity.com/");


 
     
    
});



/********* PÓS EXECUÇÃO ************/
After(function (scenarioResult) {
  let self = this;


  if (scenarioResult.result.status === 'failed') {
    browser.takeScreenshot().then(function (screenshot) {
      const decodedImage = new Buffer.from(screenshot.replace(/^data:image\/png;base64,/, ''), 'base64');
      self.attach(decodedImage, 'image/png');
      driver.executeScript(clearStorage);
      driver.manage().deleteAllCookies();
      console.log("scenarioResult  = ", scenarioResult.result.status);

    });
  }


  driver.manage().deleteAllCookies();
  return driver.executeScript(clearStorage); //função para limpar cash do navegador.

});

