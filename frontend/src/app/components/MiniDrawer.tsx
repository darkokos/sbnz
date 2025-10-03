"use client";
import {
  CSSObject,
  Divider,
  IconButton,
  List,
  ListItem,
  ListItemButton,
  ListItemIcon,
  ListItemText,
  styled,
  Theme,
  useTheme,
} from "@mui/material";
import MuiDrawer from "@mui/material/Drawer";
import { JSX, useState } from "react";
import ChevronRightIcon from "@mui/icons-material/ChevronRight";
import ChevronLeftIcon from "@mui/icons-material/ChevronLeft";
import MenuIcon from "@mui/icons-material/Menu";
import HomeIcon from "@mui/icons-material/Home";
import CloudIcon from "@mui/icons-material/Cloud";
import AcUnitIcon from "@mui/icons-material/AcUnit";
import Link from "next/link";
import { Url } from "next/dist/shared/lib/router/router";

const drawerWidth = 240;

type MenuItemMetadata = {
  icon: JSX.Element;
  name: string;
  linkPath: Url;
};

const openedMixin = (theme: Theme): CSSObject => ({
  width: drawerWidth,
  transition: theme.transitions.create("width", {
    easing: theme.transitions.easing.sharp,
    duration: theme.transitions.duration.enteringScreen,
  }),
  overflowX: "hidden",
});

const closedMixin = (theme: Theme): CSSObject => ({
  transition: theme.transitions.create("width", {
    easing: theme.transitions.easing.sharp,
    duration: theme.transitions.duration.leavingScreen,
  }),
  overflowX: "hidden",
  width: `calc(${theme.spacing(7)} + 1px)`,
  [theme.breakpoints.up("sm")]: {
    width: `calc(${theme.spacing(8)} + 1px)`,
  },
});

const Drawer = styled(MuiDrawer, {
  shouldForwardProp: (prop) => prop !== "open",
})(({ theme }) => ({
  width: drawerWidth,
  flexShrink: 0,
  whiteSpace: "nowrap",
  boxSizing: "border-box",
  variants: [
    {
      props: ({ open }) => open,
      style: {
        ...openedMixin(theme),
        "& .MuiDrawer-paper": openedMixin(theme),
      },
    },
    {
      props: ({ open }) => !open,
      style: {
        ...closedMixin(theme),
        "& .MuiDrawer-paper": closedMixin(theme),
      },
    },
  ],
}));

const DrawerHeader = styled("div")(({ theme }) => ({
  display: "flex",
  alignItems: "center",
  justifyContent: "flex-end",
  padding: `${theme.spacing(0)} calc(${theme.spacing(1)} + 1px)`,
  [theme.breakpoints.up("sm")]: {
    padding: `${theme.spacing(0)} calc(${theme.spacing(1.5)} + 1px)`,
  },
  minHeight: 64,
}));

export default function MiniDrawer() {
  const theme = useTheme();
  const [open, setOpen] = useState(false);

  const menuItems: MenuItemMetadata[] = [
    {
      icon: <HomeIcon color="primary" />,
      name: "Home State",
      linkPath: "/",
    },
    {
      icon: <CloudIcon color="primary" />,
      name: "Weather Readings",
      linkPath: "/weather",
    },
    {
      icon: <AcUnitIcon color="primary" />,
      name: "Heating Plan",
      linkPath: "/heating",
    },
  ];

  return (
    <Drawer variant="permanent" open={open}>
      <DrawerHeader>
        <IconButton onClick={() => setOpen(!open)} edge="start" color="primary">
          {open ? (
            theme.direction === "rtl" ? (
              <ChevronRightIcon />
            ) : (
              <ChevronLeftIcon />
            )
          ) : (
            <MenuIcon />
          )}
        </IconButton>
      </DrawerHeader>
      <Divider variant="middle" />
      <List>
        {menuItems.map((item) => (
          <ListItem key={item.name} disablePadding sx={{ display: "block" }}>
            <Link href={item.linkPath}>
              <ListItemButton
                sx={[
                  { minHeight: 48, px: 2.5 },
                  open
                    ? { justifyContent: "initial" }
                    : { justifyContent: "center" },
                ]}
              >
                <ListItemIcon
                  sx={[
                    { minWidth: 0, justifyContent: "center" },
                    open ? { mr: 3 } : { mr: "auto" },
                  ]}
                >
                  {item.icon}
                </ListItemIcon>
                <ListItemText
                  primary={item.name}
                  sx={[open ? { opacity: 1 } : { opacity: 0 }]}
                />
              </ListItemButton>
            </Link>
          </ListItem>
        ))}
      </List>
    </Drawer>
  );
}
