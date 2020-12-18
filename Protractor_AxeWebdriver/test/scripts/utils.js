"use strict";


//Clica em elemento
exports.elementClick = function (el) {
    return element(el).click();
};

//Preenche campos do tipo texto
exports.fillText = function (el, value) {
    return element(el).sendKeys(value);
};

