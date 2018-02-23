"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var app_component_1 = require("./app.component");
var platform_browser_1 = require("@angular/platform-browser");
core_1.NgModule({
    imports: [
        platform_browser_1.BrowserModule
    ],
    declarations: [app_component_1.AppComponent],
    bootstrap: [app_component_1.AppComponent],
    entryComponents: [app_component_1.AppComponent]
});
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
exports.AppModule = AppModule;
