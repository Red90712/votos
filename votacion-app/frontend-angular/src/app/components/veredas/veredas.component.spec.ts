import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VeredasComponent } from './veredas.component';

describe('VeredasComponent', () => {
  let component: VeredasComponent;
  let fixture: ComponentFixture<VeredasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VeredasComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VeredasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
