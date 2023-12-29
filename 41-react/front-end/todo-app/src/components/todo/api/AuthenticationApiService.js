import { apiClient } from "./apiClient";

export const excuteBasicAuthService = (token) =>
  apiClient.get(`/basicauth`, {
    headers: {
      Authorization: token,
    },
  });

export const excuteJWTAuthService = (username, password) =>
  apiClient.post(`/authenticate`, {
    username,
    password,
  });
