import { ReducersMapObject } from '@reduxjs/toolkit';
import { loadingBarReducer as loadingBar } from 'react-redux-loading-bar';
import profile from './profile';

import administration from 'app/modules/administration/administration.reducer';
import entitiesReducers from 'app/entities/reducers';
import locale from './locale';
import authentication from './authentication';
import applicationProfile from './application-profile';

import userManagement from './user-management';
/* jhipster-needle-add-reducer-import - JHipster will add reducer here */

const rootReducer: ReducersMapObject = {
  authentication,
  locale,
  applicationProfile,
  administration,
  userManagement,
  loadingBar,
  profile,
  /* jhipster-needle-add-reducer-combine - JHipster will add reducer here */
  ...entitiesReducers,
};

export default rootReducer;
