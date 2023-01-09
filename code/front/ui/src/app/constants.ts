export const myApi = 'http://localhost:8082'

export const backendUrl = {
  authService: {
    login: `${myApi}/user/login`,
    register: `${myApi}/user/register`,
    authenticate: `${myApi}/user/authenticate`,
    isConnected: `${myApi}/user/isConnected`,
    logout: `${myApi}/user/logout`,
    getUser: `${myApi}/user/username`,
    getUserLogin: `${myApi}/user/userlogin`,
  },
  imgService: {
    upload: `${myApi}/image/upload`,
    getImageById: `${myApi}/image`,
    findLatestImage: `${myApi}/image/latest`,
    findLatestImageByUser: `${myApi}/image/latest/by-user`,
    findAllByUserName: `${myApi}/image/by-user-name`,

  }
}