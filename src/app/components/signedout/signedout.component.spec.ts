import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignedoutComponent } from './signedout.component';

describe('SignedoutComponent', () => {
  let component: SignedoutComponent;
  let fixture: ComponentFixture<SignedoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SignedoutComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SignedoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
