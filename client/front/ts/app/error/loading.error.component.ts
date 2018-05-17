import { Component, ViewChild, TemplateRef, Input } from '@angular/core';
import { NgIfContext } from '@angular/common';
import { LoadingWrapper } from './LoadingErrorWrapper';

@Component({
    selector: 'loading-or-error',
    template: require('./loading.error.component.html')
})
export class LoadingOrErrorComponent {
    /**
     * The template that should get created when we are in a loading or error state.
     * Use it in the else condition of *ngIf.
     */
    @ViewChild('template') template: TemplateRef<NgIfContext>|null = null;
    /**
     * The loading wrapper that should be used to show the loading/error state
     */
    @Input() loadingWrapper: LoadingWrapper<any>|null = null;
    /**
     * A configurable error message for error cases.
     */
    @Input() errorMessage = 'A error occured!';
}