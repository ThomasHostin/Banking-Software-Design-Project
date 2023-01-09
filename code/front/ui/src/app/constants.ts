export const myhApi = 'http://localhost:8082'

export const backendUrl = {
  authService: {
    login: `${myhApi}/user/login`,
    register: `${myhApi}/user/register`,
    authenticate: `${myhApi}/user/authenticate`,
    isConnected: `${myhApi}/user/isConnected`,
    logout: `${myhApi}/user/logout`,
    getUser: `${myhApi}/user/username`,
    getUserLogin: `${myhApi}/user/userlogin`,
  },
}