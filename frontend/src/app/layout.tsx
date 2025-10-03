import { roboto } from "@/theme/fonts";
import "./globals.css";
import { AppRouterCacheProvider } from "@mui/material-nextjs/v13-appRouter";
import { ThemeProvider } from "@mui/material/styles";
import theme from "@/theme/theme";
import { Box, CssBaseline } from "@mui/material";
import MiniDrawer from "./components/MiniDrawer";
import NotistackProvider from "./contexts/NotistackProvider";

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en" className={roboto.variable}>
      <body>
        <AppRouterCacheProvider>
          <ThemeProvider theme={theme}>
            <CssBaseline />
            <Box display="flex">
              <MiniDrawer />
              <Box width="100%" marginX={2} paddingY={2}>
                <NotistackProvider
                  autoHideDuration={5000}
                  anchorOrigin={{ vertical: "top", horizontal: "right" }}
                >
                  {children}
                </NotistackProvider>
              </Box>
            </Box>
          </ThemeProvider>
        </AppRouterCacheProvider>
      </body>
    </html>
  );
}
