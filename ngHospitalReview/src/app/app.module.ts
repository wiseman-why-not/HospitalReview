import { PostService } from './services/post.service';
import { MedicalProcedureService } from './services/medical-procedure.service';
import { UserService } from './services/user.service';
import { HospitalService } from './services/hospital.service';
import { HttpClientModule} from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { FooterComponent } from './footer/footer.component';
import { SearchPageComponent } from './search-page/search-page.component';
import { SearchUsersComponent } from './util/search-users/search-users.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LandingPageComponent,
    FooterComponent,
    SearchPageComponent,
    SearchUsersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    HospitalService,
    UserService,
    MedicalProcedureService,
    PostService],
  bootstrap: [AppComponent]
})
export class AppModule { }
